public class Execution_program {
    void execution(CPU cpu, int code_count) {
        FileReader fileReader = new FileReader();
        String filePath = "./assembly.txt";
        String[] file = fileReader.readFile(filePath);
        Instruction_set isa = new Instruction_set();

        for (int i = 0; i < file.length; ++i) {
            if (cpu.RAM[cpu.INSTRUCTION_POINTER] == isa.getOpcode(file[i])) {
                if (file[i].equals("mov")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.mov(reg_source, reg_destination);
                } else if (file[i].equals("add")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.add(reg_source, reg_destination);
                } else if (file[i].equals("sub")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.sub(reg_source, reg_destination);
                }
                else if (file[i].equals("div")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.div(reg_source, reg_destination);
                }
                else if (file[i].equals("mul")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.mul(reg_source, reg_destination);
                }
                else if (file[i].equals("or")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.or(reg_source, reg_destination);
                }
                else if (file[i].equals("and")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.and(reg_source, reg_destination);
                }
                else if(file[i].equals("not")){
                    String reg_source = file[i + 1];
                    cpu.not(reg_source);
                }
                cpu.INSTRUCTION_POINTER++;
            }

        }

    }
}
