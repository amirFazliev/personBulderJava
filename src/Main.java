public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(7)
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        System.out.println(son.hasAge());

        try {
            new PersonBuilder()
                    .setName("Анна") // Не хватает обязательных полей
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(-100) // Возраст недопустимый
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}