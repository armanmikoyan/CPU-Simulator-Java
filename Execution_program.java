public class Execution_program {
    void execution(CPU cpu, int code_count) {
        FileReader fileReader = new FileReader();
        String filePath = "./assembly.txt";
        String[] file = fileReader.readFile(filePath);
        Instruction_set isa = new Instruction_set();
            for(int i = 0; i < file.length; ++i){
                System.out.println(isa.getOpcode(file[i]));
            }

    
    }
}

