public class CPU {
    // CURRENT INSTRUCTION POINTER REGISTER
    public int INSTRUCTION_POINTER;
  
    // 4 BYTE RAM
    public byte[] RAM = new byte[32];
  
    //general purpose registers
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
  
    // '+ ADD ASSEMBLY INSTRUCTION'
    public byte add(byte a, byte b) {
      return (byte)(a + b);
    }
  
    // '- SUB ASSEMBLY INSTRUCTION'
    public byte sub(byte a, byte b) {
      return (byte)(a - b);
    }
  
    // '/ DIV ASSEMBLY INSTRUCTION'
    public byte div(byte a, byte b) {
      return (byte)(a / b);
    }
  
    // '* MUL ASSEMBLY INSTRUCTION'
    public byte mul(byte a, byte b) {
      return (byte)(a * b);
    }
  
    // 'NOT ASSEMBLY INSTRUCTION'
    public byte not(byte a) {
      return (byte)((~a) + 1);
    }
    // 'OR ASSEMBLY INSTRUCTION'
    public byte or(byte a, byte b) {
      return (byte)(a | b);
    }
    // 'AND ASSEMBLY INSTRUCTION'
    public byte and(byte a, byte b) {
      return (byte)(a & b);
    }
    // 'CMP ASSEMBLY INSTRUCTION'
    public void cmp(byte a, byte b) {
      int tmp = a - b;
      if (tmp < 0) {
        ech = -1;
      } else if (tmp > 0) {
        ech = 1;
      } else {
        ech = 0;
      }
    }
    // JUMP WITHOUT CONDITION
    public void jmp(byte addr) {
      updateInstructionPointer(addr);
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
  
    public void mov(String reg_source, String reg_destination) {
      if (isNumeric(reg_destination)) { // destination literal number
        if (!checkStringFormat(reg_source)) { // case ->  mov reg, literal
          if (reg_source.equals("ayb")) {
            ayb = Byte.parseByte(reg_destination);
          } else if (reg_source.equals("ben")) {
            ben = Byte.parseByte(reg_destination);
          } else if (reg_source.equals("gim")) {
            gim = Byte.parseByte(reg_destination);
          } else if (reg_source.equals("da")) {
            da = Byte.parseByte(reg_destination);
          }
        } else if (checkStringFormat(reg_source)) { // check if source starts -> [  and ends -> ]
          RAM[toNum(reg_source)] = Byte.parseByte(reg_destination); // case ->  mov mem,literal
  
        }
  
      } else if (!isNumeric(reg_destination)) {
        if (checkStringFormat(reg_source)) {
          if (reg_destination.equals("ayb")) {
            RAM[toNum(reg_source)] = ayb;
          } else if (reg_destination.equals("ben")) {
            RAM[toNum(reg_source)] = ben;
          } else if (reg_destination.equals("gim")) {
            RAM[toNum(reg_source)] = gim;
          } else if (reg_destination.equals("da")) {
            RAM[toNum(reg_source)] = da;
          }
        } else if (!checkStringFormat(reg_destination)) {
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
        } else if (checkStringFormat(reg_destination)) {
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