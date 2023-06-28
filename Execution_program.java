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

                } else if (file[i].equals("div")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.div(reg_source, reg_destination);

                } else if (file[i].equals("mul")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.mul(reg_source, reg_destination);

                } else if (file[i].equals("or")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.or(reg_source, reg_destination);

                } else if (file[i].equals("and")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.and(reg_source, reg_destination);

                } else if (file[i].equals("cmp")) {
                    String reg_source = file[i + 1];
                    String reg_destination = file[i + 3];
                    cpu.cmp(reg_source, reg_destination);

                } else if (file[i].equals("not")) {
                    String reg_source = file[i + 1];
                    cpu.not(reg_source);

                } else if (file[i].equals("jmp")) {
                    int count = 0;
                    int tmp = 0;
                    String label_source = file[i + 1];
                    if (Byte.parseByte(label_source) > 0) {
                        for (int j = i + 1; j < file.length; ++j) {
                            count++;
                            if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                    || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                    || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                    || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                    || file[j].equals("mul")) {
                                tmp++;

                                if (tmp == Byte.parseByte(label_source)) {
                                    break;
                                }
                            }
                        }
                        i += count - 1;
                        cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                        cpu.INSTRUCTION_POINTER--;

                    } else if (Byte.parseByte(label_source) < 0) {
                        for (int j = i - 1; j >= 0; --j) {
                            count++;
                            if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                    || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                    || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                    || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                    || file[j].equals("mul")) {
                                tmp++;

                                if (tmp == ~Byte.parseByte(label_source) + 1) {
                                    break;
                                }
                            }
                        }

                        i -= count;
                        cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                    }

                } else if (file[i].equals("jg")) {
                    if (cpu.ech > 0) {

                        int count = 0;
                        int tmp = 0;
                        String label_source = file[i + 1];
                        if (Byte.parseByte(label_source) > 0) {
                            for (int j = i + 1; j < file.length; ++j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == Byte.parseByte(label_source)) {
                                        break;
                                    }
                                }
                            }
                            i += count - 1;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                            cpu.INSTRUCTION_POINTER--;

                        } else if (Byte.parseByte(label_source) < 0) {
                            for (int j = i - 1; j >= 0; --j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == ~Byte.parseByte(label_source) + 1) {
                                        break;
                                    }
                                }
                            }

                            i -= count;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                        }

                    }
                } else if (file[i].equals("jl")) {
                    if (cpu.ech < 0) {

                        int count = 0;
                        int tmp = 0;
                        String label_source = file[i + 1];
                        if (Byte.parseByte(label_source) > 0) {
                            for (int j = i + 1; j < file.length; ++j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == Byte.parseByte(label_source)) {
                                        break;
                                    }
                                }
                            }
                            i += count - 1;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                            cpu.INSTRUCTION_POINTER--;

                        } else if (Byte.parseByte(label_source) < 0) {
                            for (int j = i - 1; j >= 0; --j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == ~Byte.parseByte(label_source) + 1) {
                                        break;
                                    }
                                }
                            }

                            i -= count;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                        }

                    }
                } else if (file[i].equals("je")) {
                    if (cpu.ech == 0) {

                        int count = 0;
                        int tmp = 0;
                        String label_source = file[i + 1];
                        if (Byte.parseByte(label_source) > 0) {
                            for (int j = i + 1; j < file.length; ++j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == Byte.parseByte(label_source)) {
                                        break;
                                    }
                                }
                            }
                            i += count - 1;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                            cpu.INSTRUCTION_POINTER--;

                        } else if (Byte.parseByte(label_source) < 0) {
                            for (int j = i - 1; j >= 0; --j) {
                                count++;
                                if (file[j].equals("add") || file[j].equals("mov") || file[j].equals("sub")
                                        || file[j].equals("div") || file[j].equals("not") || file[j].equals("cmp")
                                        || file[j].equals("jmp") || file[j].equals("jl") || file[j].equals("jg")
                                        || file[j].equals("je") || file[j].equals("and") || file[j].equals("or")
                                        || file[j].equals("mul")) {
                                    tmp++;

                                    if (tmp == ~Byte.parseByte(label_source) + 1) {
                                        break;
                                    }
                                }
                            }

                            i -= count;
                            cpu.INSTRUCTION_POINTER += Byte.parseByte(label_source);
                        }

                    }
                }
                cpu.INSTRUCTION_POINTER++;

            }

        }
    }
}
