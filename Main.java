public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        byte gotoa = 0;
        cpu.RAM[0] = 99;
        cpu.updateInstructionPointer(gotoa);
        FileReader fileReader = new FileReader();
        String filePath = "./test.txt";
        String[] file = fileReader.readFile(filePath);
        for (int i = 0; i < file.length; i++) {
            if (file[i].equals("asd")) {
                System.out.println("yes");
            }
            System.out.println("Word " + i + ": " + file[i]);
        }

    }
}