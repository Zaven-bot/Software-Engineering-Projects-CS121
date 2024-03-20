import java.util.List;

public class UnitTester2 {
        @Property
        public void Chaining(@StringSet(strings={"s1", "s2", "s3"}) String s1, @StringSet(strings={"s4", "s5"}) String s2, @IntRange(min=-2, max=2) Integer i) {
                System.out.println(s1 + " - " + s2 + " - " + i);
        }

        @Property
        public void IntegerListLength(@ListLength(min=0, max=2) List<@IntRange(min=5, max=7) Integer> i) {
                System.out.println(i);
        }

        @Property
        public void StringListLength(@ListLength(min=0, max=3) List<@StringSet(strings={"hello", "hi", "hola", "goodbye", "good"}) String> s) {
                System.out.println(s);
        }

        @Property
        public void ListListLength(@ListLength(min=0, max=3) List<@ListLength(min=0, max=1) List<@IntRange(min=2, max=4) Integer>> i) {
                System.out.println(i);
        }
}


