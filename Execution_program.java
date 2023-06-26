public class Execution_program {
    void execution(CPU cpu, int code_count) {
        FileReader fileReader = new FileReader();
        String filePath = "./assembly.txt";
        String[] file = fileReader.readFile(filePath);
        Instruction_set isa = new Instruction_set();
        for(int i = 0; i< code_count;i++){
            for(int j = 0; j< file.length;j++){
              if(cpu.RAM[cpu.INSTRUCTION_POINTER] == isa.getOpcode(file[j])){
                  if(isa.getOpcode(file[j]) == 1){
                    System.out.println("mov");
                  }
               
                cpu.INSTRUCTION_POINTER++;
                break;
              }
            }
        }

    }
}
