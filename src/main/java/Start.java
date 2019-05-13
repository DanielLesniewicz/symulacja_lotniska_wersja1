public class Start {

    public static void main(String[] args) throws Exception {

        System.out.println("Zaczynamy symulację!");
        System.out.println("Na starcie steruemy trzema samolotami różnych typów, możemy nimi lądować oraz startować");
        System.out.println("Z każdą operacją związane są dodatkowe niezbędne do wykonani czynności, jak np tankowanie samolotu");
        System.out.println("Możliwe jest też, że pasy będą zajęte i nie będzie można wylądować");

        Menu.wyborTypu();
    }
}