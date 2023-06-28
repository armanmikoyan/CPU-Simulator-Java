public class Main {
    public static void main(String[] args) {
        Load_to_Ram load = new Load_to_Ram();
        load.load();
        Execution_program execution_program = new Execution_program();
        CPU cpu = load.get_cpu();
        execution_program.execution(cpu, load.get_code_count());
        // cpu.dump_memory(load.get_code_count());
        System.out.println(cpu.ben);
    }
}
