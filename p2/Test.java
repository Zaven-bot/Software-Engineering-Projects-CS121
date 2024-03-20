import java.util.*;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p = Piece.createPiece("bp");
        b.addPiece(p, "a3");
        assert b.getPiece("a3") == p;
        b.clear();
    }    

    //////////////////////////////
    // Create B/W of each piece //
    //////////////////////////////

    // Pawn //
    public static void test2() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p2 = Piece.createPiece("wp");
        b.addPiece(p2, "a3");
        assert b.getPiece("a3").color() == Color.WHITE;
        b.clear();
    }    

    // Knight //
    public static void test3() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KnightFactory());
        Piece n1 = Piece.createPiece("bn");
        Piece n2 = Piece.createPiece("wn");
        b.addPiece(n1, "a7");
        b.addPiece(n2, "b8");
        assert b.getPiece("a7").color() == Color.BLACK;
        assert b.getPiece("b8").color() == Color.WHITE;
        b.clear();
    }

    // Queen //
    public static void test4() {
        Board b = Board.theBoard();
        Piece.registerPiece(new QueenFactory());
        Piece q1 = Piece.createPiece("bq");
        Piece q2 = Piece.createPiece("wq");
        b.addPiece(q1, "a7");
        b.addPiece(q2, "b8");
        assert b.getPiece("a7").color() == Color.BLACK;
        assert b.getPiece("b8").color() == Color.WHITE;
        b.clear();
    }
    
    // King //
    public static void test5() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece k1 = Piece.createPiece("bk");
        Piece k2 = Piece.createPiece("wk");
        b.addPiece(k1, "a7");
        b.addPiece(k2, "b8");
        assert b.getPiece("a7").color() == Color.BLACK;
        assert b.getPiece("b8").color() == Color.WHITE;
        b.clear();
    }

    // Rook //
    public static void test6() {
        Board b = Board.theBoard();
        Piece.registerPiece(new RookFactory());
        Piece r1 = Piece.createPiece("br");
        Piece r2 = Piece.createPiece("wr");
        b.addPiece(r1, "a7");
        b.addPiece(r2, "b8");
        assert b.getPiece("a7").color() == Color.BLACK;
        assert b.getPiece("b8").color() == Color.WHITE;
        b.clear();
    }

    // Bishop //
    public static void test7() {
        Board b = Board.theBoard();
        Piece.registerPiece(new BishopFactory());
        Piece b1 = Piece.createPiece("br");
        Piece b2 = Piece.createPiece("wr");
        b.addPiece(b1, "a7");
        b.addPiece(b2, "b8");
        assert b.getPiece("a7").color() == Color.BLACK;
        assert b.getPiece("b8").color() == Color.WHITE;
        b.clear();
    }

    //////////////////////////////
    // Create a Full Board! :D //
    //////////////////////////////

    public static void test8() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        // Place black pieces at the top
        b.addPiece(Piece.createPiece("br"), "a8");
        b.addPiece(Piece.createPiece("bn"), "b8");
        b.addPiece(Piece.createPiece("bb"), "c8");
        b.addPiece(Piece.createPiece("bq"), "d8");
        b.addPiece(Piece.createPiece("bk"), "e8");
        b.addPiece(Piece.createPiece("bb"), "f8");
        b.addPiece(Piece.createPiece("bn"), "g8");
        b.addPiece(Piece.createPiece("br"), "h8");
        b.addPiece(Piece.createPiece("bp"), "a7");
        b.addPiece(Piece.createPiece("bp"), "b7");
        b.addPiece(Piece.createPiece("bp"), "c7");
        b.addPiece(Piece.createPiece("bp"), "d7");
        b.addPiece(Piece.createPiece("bp"), "e7");
        b.addPiece(Piece.createPiece("bp"), "f7");
        b.addPiece(Piece.createPiece("bp"), "g7");
        b.addPiece(Piece.createPiece("bp"), "h7");

        // Place white pieces at the bottom
        b.addPiece(Piece.createPiece("wp"), "a2");
        b.addPiece(Piece.createPiece("wp"), "b2");
        b.addPiece(Piece.createPiece("wp"), "c2");
        b.addPiece(Piece.createPiece("wp"), "d2");
        b.addPiece(Piece.createPiece("wp"), "e2");
        b.addPiece(Piece.createPiece("wp"), "f2");
        b.addPiece(Piece.createPiece("wp"), "g2");
        b.addPiece(Piece.createPiece("wp"), "h2");
        b.addPiece(Piece.createPiece("wr"), "a1");
        b.addPiece(Piece.createPiece("wn"), "b1");
        b.addPiece(Piece.createPiece("wb"), "c1");
        b.addPiece(Piece.createPiece("wq"), "d1");
        b.addPiece(Piece.createPiece("wk"), "e1");
        b.addPiece(Piece.createPiece("wb"), "f1");
        b.addPiece(Piece.createPiece("wn"), "g1");
        b.addPiece(Piece.createPiece("wr"), "h1");

        b.clear();
    }

    //////////////////////////////
    // Functional Pawn Tests    //
    //////////////////////////////

    public static void test9() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        Piece bp = Piece.createPiece("bp");
        Piece wp = Piece.createPiece("wp");
        
        // Black pawns
        b.addPiece(bp, "a7");
        b.addPiece(bp, "b7");
        b.addPiece(bp, "c7");
        b.addPiece(bp, "d7");

        Piece a7pawn = b.getPiece("a7");
        List<String> a7moves =  a7pawn.moves(b, "a7");
        System.out.println("a7pawn:");
        for (int i = 0; i < a7moves.size(); i++) {
            System.out.println(a7moves.get(i));
        }
        System.out.println("\n");

        Piece b7pawn = b.getPiece("b7");
        List<String> b7moves =  b7pawn.moves(b, "b7");
        System.out.println("b7pawn:");
        for (int i = 0; i < b7moves.size(); i++) {
            System.out.println(b7moves.get(i));
        }
        System.out.println("\n");

        Piece c7pawn = b.getPiece("c7");
        List<String> c7moves =  c7pawn.moves(b, "c7");
        System.out.println("c7pawn:");
        for (int i = 0; i < c7moves.size(); i++) {
            System.out.println(c7moves.get(i));
        }
        System.out.println("\n");

        Piece d7pawn = b.getPiece("d7");
        List<String> d7moves =  d7pawn.moves(b, "d7");
        System.out.println("d7pawn:");
        for (int i = 0; i < d7moves.size(); i++) {
            System.out.println(d7moves.get(i));
        }
        System.out.println("\n");

        // White pawns
        b.addPiece(wp, "b2");
        b.addPiece(wp, "c2");
        b.addPiece(wp, "d2");
        b.addPiece(wp, "e2");

       Piece b2pawn = b.getPiece("b2");
        List<String> b2moves =  b2pawn.moves(b, "b2");
        System.out.println("b2pawn:");
        for (int i = 0; i < b2moves.size(); i++) {
            System.out.println(b2moves.get(i));
        }
        System.out.println("\n");

        Piece c2pawn = b.getPiece("c2");
        List<String> c2moves =  c2pawn.moves(b, "c2");
        System.out.println("c2pawn:");
        for (int i = 0; i < c2moves.size(); i++) {
            System.out.println(c2moves.get(i));
        }
        System.out.println("\n");

        Piece d2pawn = b.getPiece("d2");
        List<String> d2moves =  d2pawn.moves(b, "d2");
        System.out.println("d2pawn:");
        for (int i = 0; i < d2moves.size(); i++) {
            System.out.println(d2moves.get(i));
        }
        System.out.println("\n");

        Piece e2pawn = b.getPiece("e2");
        List<String> e2moves =  e2pawn.moves(b, "e2");
        System.out.println("e2pawn:");
        for (int i = 0; i < e2moves.size(); i++) {
            System.out.println(e2moves.get(i));
        }
        System.out.println("\n");

        b.clear();
    }    

    public static void test10() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        b.addPiece(Piece.createPiece("bp"), "d5");
        b.addPiece(Piece.createPiece("wp"), "e4");
        b.addPiece(Piece.createPiece("wp"), "f5");

        // Piece e4pawn = b.getPiece("e4");
        // List<String> e4moves =  e4pawn.moves(b, "e4");
        // System.out.println("e4pawn:");
        // for (int i = 0; i < e4moves.size(); i++) {
        //     System.out.println(e4moves.get(i));
        // }
        // System.out.println("\n");

        // b.addPiece(Piece.createPiece("bp"), "e5");
        // b.addPiece(Piece.createPiece("wp"), "e5");

        Piece e4pawn = b.getPiece("e4");
        List<String> e4moves =  e4pawn.moves(b, "e4");
        System.out.println("e4pawn:");
        for (int i = 0; i < e4moves.size(); i++) {
            System.out.println(e4moves.get(i));
        }
        System.out.println("\n");

        b.clear();
    }

    //////////////////////////////
    // Functional Queen Tests   //
    //////////////////////////////
    public static void test11() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        // b.addPiece(Piece.createPiece("wp"), "d2");
        // b.addPiece(Piece.createPiece("wq"), "d1");
        // b.addPiece(Piece.createPiece("wp"), "c2");
        // b.addPiece(Piece.createPiece("wp"), "e2");
        // b.addPiece(Piece.createPiece("wp"), "c1");
        // b.addPiece(Piece.createPiece("wp"), "e1");

        b.addPiece(Piece.createPiece("wq"), "d5");

        Piece d5queen = b.getPiece("d5");
        List<String> d5moves =  d5queen.moves(b, "d5");
        System.out.println("d5queen:");
        for (int i = 0; i < d5moves.size(); i++) {
            System.out.println(d5moves.get(i));
        }
        b.clear();
    }

    //////////////////////////////
    // Functional Bishop Tests  //
    //////////////////////////////
    public static void test12() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        b.addPiece(Piece.createPiece("wb"), "d5");
        b.addPiece(Piece.createPiece("wp"), "c6");
        b.addPiece(Piece.createPiece("wp"), "e6");
        b.addPiece(Piece.createPiece("wp"), "e4");
        b.addPiece(Piece.createPiece("wp"), "c4");
    
        Piece d5bishop = b.getPiece("d5");
        List<String> d5moves = d5bishop.moves(b, "d5");
        System.out.println("d5bishop:");
        for (int i = 0; i < d5moves.size(); i++) {
            System.out.println(d5moves.get(i));
        }

        b.clear();
    }

    //////////////////////////////
    // Functional Rook Tests  //
    //////////////////////////////
    public static void test13() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        b.addPiece(Piece.createPiece("wr"), "d5");
        b.addPiece(Piece.createPiece("wp"), "c5");
        b.addPiece(Piece.createPiece("wp"), "e5");
        b.addPiece(Piece.createPiece("wp"), "d4");
        b.addPiece(Piece.createPiece("wp"), "d6");
    
        Piece d5rook = b.getPiece("d5");
        List<String> d5moves = d5rook.moves(b, "d5");
        System.out.println("d5rook:");
        for (int i = 0; i < d5moves.size(); i++) {
            System.out.println(d5moves.get(i));
        }

        b.clear();
    }

    //////////////////////////////
    // Functional King Tests  //
    //////////////////////////////
    public static void test14() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        b.addPiece(Piece.createPiece("wk"), "d5");
        b.addPiece(Piece.createPiece("bp"), "c5");
        b.addPiece(Piece.createPiece("bp"), "e5");
        b.addPiece(Piece.createPiece("bp"), "d4");
        b.addPiece(Piece.createPiece("bp"), "d6");
        b.addPiece(Piece.createPiece("bp"), "e6");
        b.addPiece(Piece.createPiece("bp"), "e4");
        b.addPiece(Piece.createPiece("bp"), "c4");
        b.addPiece(Piece.createPiece("bp"), "c6");
    
        Piece d5king = b.getPiece("d5");
        List<String> d5moves = d5king.moves(b, "d5");
        System.out.println("d5king:");
        for (int i = 0; i < d5moves.size(); i++) {
            System.out.println(d5moves.get(i));
        }

        b.clear();
    }

    //////////////////////////////
    // Functional Knight Tests  //
    //////////////////////////////
    public static void test15() {
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new KnightFactory());
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());

        b.addPiece(Piece.createPiece("wn"), "d5");
        b.addPiece(Piece.createPiece("wp"), "b6");
        b.addPiece(Piece.createPiece("wp"), "c7");
        b.addPiece(Piece.createPiece("wp"), "e7");
        b.addPiece(Piece.createPiece("wp"), "f6");
        b.addPiece(Piece.createPiece("wp"), "f4");
        b.addPiece(Piece.createPiece("wp"), "e3");
        b.addPiece(Piece.createPiece("wp"), "c3");
        b.addPiece(Piece.createPiece("wp"), "b4");
    
        Piece d5knight = b.getPiece("d5");
        List<String> d5moves = d5knight.moves(b, "d5");
        System.out.println("d5knight:");
        for (int i = 0; i < d5moves.size(); i++) {
            System.out.println(d5moves.get(i));
        }

        b.clear();
    }

    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        // test6();
        // test7();
        // test8();
        // test9();
        // test10();
        // test11();
        // test12();
        // test13();
        // test14();
        test15();
    }

}
