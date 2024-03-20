import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class Sim {

  public static void run_sim(MBTA mbta, Log log) {
    // Map to store threads for passengers and trains
    Map<String, Thread> trainPassengerThreads = new HashMap<>();

    // Create and store threads for passengers
    for (String passenger: mbta.mbtaGetPassengerList()) {
      // Store PassengerThread to simulate passenger actions
      trainPassengerThreads.put(passenger, new PassengerThread(passenger, mbta, log));
      // System.out.println("Passenger threads successfully made.\n");
    }
    
    // Create and store threads for trains (lines)
    for (String train: mbta.mbtaGetTrainList()) {
      // Store TrainThreadss to simulate a train actions
      trainPassengerThreads.put(train, new TrainThread(train, mbta, log));
      // System.out.println("Train threads successfully made.\n");
    }

    // Start all threads
    for (Thread thread : trainPassengerThreads.values()) {
      // System.out.println("Threads started\n");
      thread.start();
    }

    try {
      // Wait for all threads to complete
      for (Thread thread : trainPassengerThreads.values()) {
        // System.out.println("Threads joined.\n")
        thread.join();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Run_Sim is complete.");
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("usage: ./sim <config file>");
      System.exit(1);
    }

    MBTA mbta = new MBTA();
    mbta.loadConfig(args[0]);

    Log log = new Log();

    run_sim(mbta, log);

    String s = new LogJson(log).toJson();
    PrintWriter out = new PrintWriter("log.json");
    out.print(s);
    out.close();

    mbta.reset();

    mbta.loadConfig(args[0]);
    Verify.verify(mbta, log);
  }
}
