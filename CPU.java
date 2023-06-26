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
            RAM[i] = i;
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
    public void mov(String reg_source, String reg_destination, byte ram_addr, byte data) {
        if (reg_destination.isEmpty() && ram_addr == 0) { // case when data transfer is  ->  mov reg,literal
            if (reg_source.equals("ayb")) {
                ayb = data;
            } else if (reg_source.equals("ben")) {
                ben = data;
            } else if (reg_source.equals("gim")) {
                gim = data;
            } else if (reg_source.equals("da")) {
                da = data;
            } else if (reg_source.equals("ech") || reg_source.equals("za")) {
                System.out.print("You can't use '" + reg_source + "' register");
            } else {
                System.out.print(reg_source + " doesn't exist");
            }
        } else if (!(reg_source.isEmpty()) && !(reg_destination.isEmpty()) && ram_addr == 0 && data == 0) { // case when data transfer is  ->  mov reg,reg
            reg_source = reg_destination;
        } else if (ram_addr != 0 && reg_destination.isEmpty() && reg_destination.isEmpty()) { // case when data transfer is  ->  mov ram ,literal
            RAM[ram_addr] = data;
        } else if (reg_destination.isEmpty() && data == 0) { // case when data transfer is  ->  mov reg,ram
            if (reg_source.equals("ayb")) {
                ayb = RAM[ram_addr];;
            } else if (reg_source.equals("ben")) {
                ben = RAM[ram_addr];;
            } else if (reg_source.equals("gim")) {
                gim = RAM[ram_addr];;
            } else if (reg_source.equals("da")) {
                da = RAM[ram_addr];;
            } else if (reg_source.equals("ech") || reg_source.equals("za")) {
                System.out.print("You can't use '" + reg_source + "' register");
            } else {
                System.out.print(reg_source + " doesn't exist");
            }
        }
    }
}