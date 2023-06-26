public class Instruction_set {
 public  byte mov = 1;
 public  byte add = 2;
 public  byte sub = 3;
 public  byte div = 4;
 public  byte mul = 5;
 public  byte and = 6;
 public  byte or =  7;
 public  byte not = 8;
 public  byte cmp = 9;
 public  byte jmp = 10;
 public  byte jl =  11;
 public  byte jg =  12;
 public  byte je =  13;
 public byte getOpcode(String instruction) {
    switch (instruction) {
        case "mov":
            return mov;
        case "add":
            return add;
        case "sub":
            return sub;
        case "div":
            return div;
        case "mul":
            return mul;
        case "and":
            return and;
        case "or":
            return or;
        case "not":
            return not;
        case "cmp":
            return cmp;
        case "jmp":
            return jmp;
        case "jl":
            return jl;
        case "jg":
            return jg;
        case "je":
            return je;
        default:
            return 99;
    }
}

}
