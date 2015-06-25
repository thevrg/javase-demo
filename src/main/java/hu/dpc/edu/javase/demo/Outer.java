package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class Outer {
    
    private static long counter;
    private long id = ++counter;
    private String name;

    public Outer(String name) {
        this.name = name;
    }
    
    public static class NestedStatic {
        private String name;
        

        public NestedStatic(String name) {
            this.name = name;
        }
        
        public String getInfo(Outer outer) {
            return "id: " + outer.id + ", name : " + outer.name;
        }
        
        @Override
        public String toString() {
            return "NestedStatic " + name  + ", Outer.counter: " + counter;
        }
    }
    
    public static NestedStatic createNestedStatic(String name) {
        return new NestedStatic(name);
    }
    
    public Inner createInner(String name) {
        return new Inner(name);
    }
    
    public Object createLocal(final String name, final int szam) {
        
        class MyClass {
            private String name;

            public MyClass(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "MyClass{" + "name=" + name + ", Outer.this.name=" + Outer.this.name + ", szam: " + szam + '}' ;
            }
            
        }
        
        return new MyClass(name);
    }
    
    public MySuper createAnonymous(final String name, final int szam) {
        
        return new MySuper(szam * 10) {
            @Override
            public String toString() {
                return "Anon{" + "name=" + name + ", Outer.this.name=" + Outer.this.name + ", szam: " + szam + ", getId(): " +  getId() + '}' ;
            }
            
        };
        
    }
    
    public class Inner {
        
        private String name;

        public Inner(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "Inner name = " + name + ", Outer.this.name = " + Outer.this.name;
        }
    }

    @Override
    public String toString() {
        return "Outer{" + "name=" + name + '}';
    }
    
}
