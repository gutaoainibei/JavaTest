package designPattern.Mediator;

public interface Mediator {
    public void command(String name);
    public void register(String name, Department department);
}
