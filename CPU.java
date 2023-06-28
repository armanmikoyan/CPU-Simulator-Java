public class CPU {
    // CURRENT INSTRUCTION POINTER REGISTER
    public int INSTRUCTION_POINTER;

    // 4 BYTE RAM
    public byte[] RAM = new byte[32];

    // general purpose registers
    public byte ayb;
    public byte ben;
    public byte gim;
    public byte da;

    // cpm result register
    public byte ech;

    // flag register
    public byte za;

    // INSTRUCTIONS...

    // update ip register
    public void updateInstructionPointer(byte i) {
        INSTRUCTION_POINTER = RAM[i];
    }

    // show each byte of ram
    public void dump_memory(byte i) {
        for (; i < RAM.length; i++) {
            System.out.println("0x" + i + ": " + RAM[i]);
        }
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean checkStringFormat(String str) {
        if (str.startsWith("[") && str.endsWith("]")) {
            return true;
        } else {
            return false;
        }
    }

    public int toNum(String str) {
        if (str.startsWith("[") && str.endsWith("]")) {
            String numberString = str.substring(1, str.length() - 1);
            return Integer.parseInt(numberString);
        }

        return -1;
    }

    // '+ ADD ASSEMBLY INSTRUCTION'
    public void add(String source, String destination) {
        if (isNumeric(destination)) { // add reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb + Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben + Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim + Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da + Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // add reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb + RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben + RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim + RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben + RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // add reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb += ben;
                } else if (destination.equals("gim")) {
                    ayb += gim;
                } else if (destination.equals("da")) {
                    ayb += da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben += ayb;
                } else if (destination.equals("gim")) {
                    ben += gim;
                } else if (destination.equals("da")) {
                    ben += da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim += ayb;
                } else if (destination.equals("ben")) {
                    gim += ben;
                } else if (destination.equals("da")) {
                    gim += da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da += ayb;
                } else if (destination.equals("ben")) {
                    da += ben;
                } else if (destination.equals("gim")) {
                    da += gim;
                }
            }
        }
    }

    // '- SUB ASSEMBLY INSTRUCTION'
    public void sub(String source, String destination) {
        if (isNumeric(destination)) { // sub reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb - Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben - Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim - Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da - Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // sub reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb - RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben - RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim - RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben - RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // sub reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb -= ben;
                } else if (destination.equals("gim")) {
                    ayb -= gim;
                } else if (destination.equals("da")) {
                    ayb -= da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben -= ayb;
                } else if (destination.equals("gim")) {
                    ben -= gim;
                } else if (destination.equals("da")) {
                    ben -= da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim -= ayb;
                } else if (destination.equals("ben")) {
                    gim -= ben;
                } else if (destination.equals("da")) {
                    gim -= da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da -= ayb;
                } else if (destination.equals("ben")) {
                    da -= ben;
                } else if (destination.equals("gim")) {
                    da -= gim;
                }
            }
        }
    }

    // '/ DIV ASSEMBLY INSTRUCTION'
    public void div(String source, String destination) {
        if (isNumeric(destination)) { // sub reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb / Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben / Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim / Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da / Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // sub reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb / RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben / RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim / RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben / RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // sub reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb /= ben;
                } else if (destination.equals("gim")) {
                    ayb /= gim;
                } else if (destination.equals("da")) {
                    ayb /= da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben /= ayb;
                } else if (destination.equals("gim")) {
                    ben /= gim;
                } else if (destination.equals("da")) {
                    ben /= da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim /= ayb;
                } else if (destination.equals("ben")) {
                    gim /= ben;
                } else if (destination.equals("da")) {
                    gim /= da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da /= ayb;
                } else if (destination.equals("ben")) {
                    da /= ben;
                } else if (destination.equals("gim")) {
                    da /= gim;
                }
            }
        }
    }

    // '* MUL ASSEMBLY INSTRUCTION'
    public void mul(String source, String destination) {
        if (isNumeric(destination)) { // sub reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb * Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben * Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim * Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da * Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // sub reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb * RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben * RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim * RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben * RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // sub reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb *= ben;
                } else if (destination.equals("gim")) {
                    ayb *= gim;
                } else if (destination.equals("da")) {
                    ayb *= da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben *= ayb;
                } else if (destination.equals("gim")) {
                    ben *= gim;
                } else if (destination.equals("da")) {
                    ben *= da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim *= ayb;
                } else if (destination.equals("ben")) {
                    gim *= ben;
                } else if (destination.equals("da")) {
                    gim *= da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da *= ayb;
                } else if (destination.equals("ben")) {
                    da *= ben;
                } else if (destination.equals("gim")) {
                    da *= gim;
                }
            }
        }
    }

    // 'NOT ASSEMBLY INSTRUCTION'
    public void not(String source) { // not reg not works only with regiser
        if (source.equals("ayb")) {
            ayb = (byte) (~ayb + 1);
        } else if (source.equals("ben")) {
            ben = (byte) (~ben + 1);
        } else if (source.equals("gim")) {
            gim = (byte) (~gim + 1);
        } else if (source.equals("da")) {
            da = (byte) (~da + 1);
        }
    }

    // 'OR ASSEMBLY INSTRUCTION'
    public void or(String source, String destination) {
        if (isNumeric(destination)) { // or reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb | Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben | Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim | Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da | Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // or reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb | RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben | RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim | RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben | RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // or reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb |= ben;
                } else if (destination.equals("gim")) {
                    ayb |= gim;
                } else if (destination.equals("da")) {
                    ayb |= da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben |= ayb;
                } else if (destination.equals("gim")) {
                    ben |= gim;
                } else if (destination.equals("da")) {
                    ben |= da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim |= ayb;
                } else if (destination.equals("ben")) {
                    gim |= ben;
                } else if (destination.equals("da")) {
                    gim |= da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da |= ayb;
                } else if (destination.equals("ben")) {
                    da |= ben;
                } else if (destination.equals("gim")) {
                    da |= gim;
                }
            }
        }
    }

    // 'AND ASSEMBLY INSTRUCTION'
    public void and(String source, String destination) {
        if (isNumeric(destination)) { // and reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    ayb = (byte) (ayb & Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    ben = (byte) (ben & Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    gim = (byte) (gim & Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    da = (byte) (da & Byte.parseByte(destination));
                }
            }
        } else if (checkStringFormat(destination)) { // and reg , mem
            if (source.equals("ayb")) {
                ayb = (byte) (ayb & RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben & RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                gim = (byte) (gim & RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                ben = (byte) (ben & RAM[toNum(destination)]);
            }
        } else if (!checkStringFormat(destination)) { // and reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    ayb &= ben;
                } else if (destination.equals("gim")) {
                    ayb &= gim;
                } else if (destination.equals("da")) {
                    ayb &= da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    ben &= ayb;
                } else if (destination.equals("gim")) {
                    ben &= gim;
                } else if (destination.equals("da")) {
                    ben &= da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    gim &= ayb;
                } else if (destination.equals("ben")) {
                    gim &= ben;
                } else if (destination.equals("da")) {
                    gim &= da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    da &= ayb;
                } else if (destination.equals("ben")) {
                    da &= ben;
                } else if (destination.equals("gim")) {
                    da &= gim;
                }
            }
        }
    }

    // 'CMP ASSEMBLY INSTRUCTION'
    public void cmp(String source, String destination) {
        int result = 0;
        if (!checkStringFormat(destination)) { // cmp reg , reg
            if (source.equals("ayb")) {
                if (destination.equals("ben")) {
                    result = ayb - ben;
                } else if (destination.equals("gim")) {
                    result = ayb - gim;
                } else if (destination.equals("da")) {
                    result = ayb - da;
                }
            } else if (source.equals("ben")) {
                if (destination.equals("ayb")) {
                    result = ben - ayb;
                } else if (destination.equals("gim")) {
                    ben &= gim;
                } else if (destination.equals("da")) {
                    result = ben - da;
                }
            } else if (source.equals("gim")) {
                if (destination.equals("ayb")) {
                    result = gim - ayb;
                } else if (destination.equals("ben")) {
                    result = gim - ben;
                } else if (destination.equals("da")) {
                    result = gim - da;
                }
            } else if (source.equals("da")) {
                if (destination.equals("ayb")) {
                    result = da - ayb;
                } else if (destination.equals("ben")) {
                    result = da - ben;
                } else if (destination.equals("gim")) {
                    result = da - gim;
                }
            }
        } else if (checkStringFormat(destination)) { // cmp reg , mem
            if (source.equals("ayb")) {
                result = (byte) (ayb - RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                result = (byte) (ben - RAM[toNum(destination)]);
            } else if (source.equals("gim")) {
                result = (byte) (gim - RAM[toNum(destination)]);
            } else if (source.equals("ben")) {
                result = (byte) (ben - RAM[toNum(destination)]);
            }
        }
        if (isNumeric(destination)) { // cmp reg , literal
            if (!checkStringFormat(destination)) {
                if (source.equals("ayb")) {
                    result = (byte) (ayb - Byte.parseByte(destination));
                } else if (source.equals("ben")) {
                    result = (byte) (ben - Byte.parseByte(destination));
                } else if (source.equals("gim")) {
                    result = (byte) (gim - Byte.parseByte(destination));
                } else if (source.equals("da")) {
                    result = (byte) (da - Byte.parseByte(destination));
                }
            }
        }
        if (result < 0) {
            ech = -1;
        } else if (result > 0) {

            ech = 1;
        } else {
            ech = 0;
        }
    }

    // JUMP WITHOUT CONDITION
    public void jmp(String source , int count) {
        updateInstructionPointer((byte)count);

    }

    // JUMP IF GREATER
    public void jg(byte addr) {
        if (ech == 1) {
            updateInstructionPointer(addr);
        }
    }

    // JUMP IF lower
    public void jl(byte addr) {
        if (ech == -1) {
            updateInstructionPointer(addr);
        }
    }

    // JUMP IF equal
    public void je(byte addr) {
        if (ech == 0) {
            updateInstructionPointer(addr);
        }
    }

    // 'MOV ASSEMBLY INSTRUCTION'

    public void mov(String reg_source, String reg_destination) {
        if (isNumeric(reg_destination)) { // destination literal number
            if (!checkStringFormat(reg_source)) { // case -> mov reg, literal
                if (reg_source.equals("ayb")) {
                    ayb = Byte.parseByte(reg_destination);
                } else if (reg_source.equals("ben")) {
                    ben = Byte.parseByte(reg_destination);
                } else if (reg_source.equals("gim")) {
                    gim = Byte.parseByte(reg_destination);
                } else if (reg_source.equals("da")) {
                    da = Byte.parseByte(reg_destination);
                }
            } else if (checkStringFormat(reg_source)) { // check if source starts -> [ and ends -> ]
                RAM[toNum(reg_source)] = Byte.parseByte(reg_destination); // case -> mov mem,literal

            }

        } else if (!isNumeric(reg_destination)) {
            if (checkStringFormat(reg_source)) { // mov mem , reg
                if (reg_destination.equals("ayb")) {
                    RAM[toNum(reg_source)] = ayb;
                } else if (reg_destination.equals("ben")) {
                    RAM[toNum(reg_source)] = ben;
                } else if (reg_destination.equals("gim")) {
                    RAM[toNum(reg_source)] = gim;
                } else if (reg_destination.equals("da")) {
                    RAM[toNum(reg_source)] = da;
                }
            } else if (!checkStringFormat(reg_destination)) { // mov reg , reg
                if (reg_source.equals("ayb")) {
                    if (reg_destination.equals("ben")) {
                        ayb = ben;
                    } else if (reg_destination.equals("gim")) {
                        ayb = gim;
                    } else if (reg_destination.equals("da")) {
                        ayb = da;
                    }

                } else if (reg_source.equals("ben")) {
                    if (reg_destination.equals("ayb")) {
                        ben = ayb;
                    } else if (reg_destination.equals("gim")) {
                        ben = gim;
                    } else if (reg_destination.equals("da")) {
                        ben = da;
                    }
                } else if (reg_source.equals("gim")) {
                    if (reg_destination.equals("ayb")) {
                        gim = ayb;
                    } else if (reg_destination.equals("ben")) {
                        gim = ben;
                    } else if (reg_destination.equals("da")) {
                        gim = da;
                    }
                } else if (reg_source.equals("da")) {
                    if (reg_destination.equals("ayb")) {
                        da = ayb;
                    } else if (reg_destination.equals("ben")) {
                        da = ben;
                    } else if (reg_destination.equals("gim")) {
                        da = gim;
                    }
                }
            } else if (checkStringFormat(reg_destination)) { // mov reg , mem
                if (reg_source.equals("ayb")) {
                    ayb = (byte) toNum(reg_destination);
                } else if (reg_source.equals("ben")) {
                    ben = (byte) toNum(reg_destination);
                } else if (reg_source.equals("gim")) {
                    gim = (byte) toNum(reg_destination);
                } else if (reg_source.equals("da")) {
                    da = (byte) toNum(reg_destination);
                }
            }

        }

    }
}