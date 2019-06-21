package StackADT;

public class Tuple<A, B> {
        public final A a;
        public final B b;

        public Tuple(A a, B b) {
            this.a = a;
            this.b = b;
        }


        public String toString() {
            return tupleToString(this);
        }

       public String tupleToString(Tuple<A, B> tuple)  {
            return "<<" + this.a + "> <" + this.b + ">>";
       }

       public boolean equals(Object o) {
            return o instanceof Tuple && isEqualTo((Tuple<A, B>) o);
       }

       private boolean isEqualTo(Tuple<A, B> t)
       {
            return this.a.equals(t.a) && this.b.equals(t.b);
       }


}
