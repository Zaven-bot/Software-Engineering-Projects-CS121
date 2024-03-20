import java.util.*;

public class MoveEvent implements Event {
  public final Train t; public final Station s1, s2;
  public MoveEvent(Train t, Station s1, Station s2) {
    this.t = t; this.s1 = s1; this.s2 = s2;
  }
  public boolean equals(Object o) {
    if (o instanceof MoveEvent e) {
      return t.equals(e.t) && s1.equals(e.s1) && s2.equals(e.s2);
    }
    return false;
  }
  public int hashCode() {
    return Objects.hash(t, s1, s2);
  }
  public String toString() {
    return "Train " + t + " moves from " + s1 + " to " + s2;
  }
  public List<String> toStringList() {
    return List.of(t.toString(), s1.toString(), s2.toString());
  }
  
  /*
  * Name: replayAndCheck
  * Purpose: Replays the MoveEvent on the provided MBTA simulation doing an integrity check.
  * Input: mbta - The MBTA simulation on which to replay the event
  * Returns: None
  * Notes: 
  */
  public void replayAndCheck(MBTA mbta) {
    String destination = s2.toString();
    String start = s1.toString();
    String train = t.toString();
    int trainIndex = mbta.mbtaGetTrainIndex(train);
    List<String> trainStations = mbta.mbtaGetStations(train);

    // Check if train is at the expected starting station
    if (!trainStations.get(trainIndex).equals(start)) {
      System.out.println("Unable to move train " + train + " to " + destination + ". Train is not at " + start);
      throw new RuntimeException();
    }

    int numStations = trainStations.size();
    // Adjust train direction based off of the current position
    if (trainIndex == numStations - 1) {
      mbta.mbtaSetTrainDirection(train, -1);
    } else if (trainIndex == 0) {
      mbta.mbtaSetTrainDirection(train, 1);
    }
  
    // Get train direction determined from trainIndex
    int trainDirection = mbta.mbtaGetTrainDirection(train);
  
    // Check if the destination station is not occupied
    if (mbta.mbtaGetStationOcc(destination) == null) {
      // Check if the next station in the train's route matches the expected destination
      if (trainStations.get(trainIndex + trainDirection).equals(destination)) {
        // Update train's progress, station's occupation status, and empty the station
        mbta.mbtaSetTrainProgress(train, trainIndex + trainDirection);
        mbta.mbtaSetStationOcc(destination, train);
        // System.out.println("Train: " + train + "from " + trainIndex + " to " + (trainDirection + trainIndex));
        mbta.mbtaEmptyStation(start);      
      } else {
        System.out.println("The next Instruction:" + trainStations.get(trainIndex + trainDirection) + " is not Destination:" + destination);
        throw new RuntimeException();
      }
    } else {
      System.out.println("The destination for Train:" + train + " is occupied.");
      throw new RuntimeException();
    }
  }
}

