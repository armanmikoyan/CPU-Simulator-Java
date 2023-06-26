public class Execution_program {
    void execution(CPU cpu, int code_count) {
        FileReader fileReader = new FileReader();
        String filePath = "./assembly.txt";
        String[] file = fileReader.readFile(filePath);
        Instruction_set isa = new Instruction_set();
  
            for(int i = 0; i < file.length; ++i){
                if(cpu.RAM[cpu.INSTRUCTION_POINTER] == isa.getOpcode(file[i])){
                    String reg_source = file[i+1];
                    String reg_destination = file[i+3];    
                   if(file[i].equals("mov")){
                        cpu.mov(reg_source, reg_destination);     
                   } 
                   cpu.INSTRUCTION_POINTER++;
                }

            }

    
    }
}

