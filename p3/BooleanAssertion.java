public class BooleanAssertion {
        private boolean boolVal;

        public BooleanAssertion(boolean b) {
                boolVal = b;
        }

        public BooleanAssertion isEqualTo(boolean b2) {
                if (boolVal != b2) {
                        throw new RuntimeException("Booleans b and b2 aren't equal");
                }
                return this;
        }

        public BooleanAssertion isTrue() {
                if (!boolVal) {
                        throw new RuntimeException("Boolean b is not true");
                }
                return this;
        }

        public BooleanAssertion isFalse() {
                if (boolVal) {
                        throw new RuntimeException("Boolean b is not false");
                }
                return this;
        }
}
