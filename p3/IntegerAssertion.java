public class IntegerAssertion {
        private int intVal;

        public IntegerAssertion(int i) {
                intVal = i;
        }

        public IntegerAssertion isEqualTo(int i2) {
                if (intVal != i2) {
                        throw new RuntimeException("Integers i and i2 aren't equal");
                }
                return this;
        }

        public IntegerAssertion isLessThan(int i2) {
                if (intVal >= i2) {
                        throw new RuntimeException("Integers i is not less than i2");
                }
                return this;
        }

        public IntegerAssertion isGreaterThan(int i2) {
                if (intVal <= i2) {
                        throw new RuntimeException("Integers i is not greater than i2");
                }
                return this;
        }
}
