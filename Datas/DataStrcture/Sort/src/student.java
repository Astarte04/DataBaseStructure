
        public class student implements Comparable<student> {
            private int age;
            private String name;
            public student(int age, String name) {
                this.age = age;
                this.name = name;
            }
            public int getAge() {
                return age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public int compareTo(student o) {
                return this.getAge() - o.getAge();
            }

            @Override
            public String toString() {
                return "name:  " +name + " age: " +age;

            }
        }
