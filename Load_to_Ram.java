public class Load_to_Ram { 
 public   byte code_count = 0;
    CPU cpu = new CPU();

    CPU get_cpu(){
        return cpu;
    }
    byte get_code_count(){
        return code_count;
    }
    void load(){
    Instruction_set instruction_set = new Instruction_set();
  
    FileReader fileReader = new FileReader();
    String filePath = "./assembly.txt";
    String[] file = fileReader.readFile(filePath);
    for (int i = 0; i < file.length; i++) {
            if(file[i].equals("mov")){
                cpu.RAM[code_count] = instruction_set.mov;
                code_count++;
            }
            else if(file[i].equals("add")){
                cpu.RAM[code_count] = instruction_set.add;
                code_count++;
            }
            else if(file[i].equals("cmp")){
                cpu.RAM[code_count] = instruction_set.cmp;
                code_count++;
            }
            else if(file[i].equals("sub")){
                cpu.RAM[code_count] = instruction_set.sub;
                code_count++;
            }
            else if(file[i].equals("div")){
                cpu.RAM[code_count] = instruction_set.div;
                code_count++;
            }
            else if(file[i].equals("mul")){
                cpu.RAM[code_count] = instruction_set.mul;
                code_count++;
            }
            else if(file[i].equals("or")){
                cpu.RAM[code_count] = instruction_set.or;
                code_count++;
            }
            else if(file[i].equals("not")){
                cpu.RAM[code_count] = instruction_set.not;
                code_count++;
            }
            else if(file[i].equals("jmp")){
                cpu.RAM[code_count] = instruction_set.jmp;
                code_count++;
            }
            else if(file[i].equals("jg")){
                cpu.RAM[code_count] = instruction_set.jg;
                code_count++;
            }
            else if(file[i].equals("jl")){
                cpu.RAM[code_count] = instruction_set.jl;
                code_count++;
            }
            else if(file[i].equals("je")){
                cpu.RAM[code_count] = instruction_set.je;
                code_count++;
            }
            else if(file[i].equals("and")){
                cpu.RAM[code_count] = instruction_set.and;
                code_count++;
            }


               
    }
  }
  
}