
//command interface
interface Command{
    void execute();
    void undo();
}

//Receivers
class Light{
    public void on(){
        System.out.println("Light is ON");
    }
    public void off(){
        System.out.println("Light is OFF");
    }
}

class Fan{
    public void on(){
        System.out.println("Fan is ON");
    }
    public void off(){
        System.out.println("Fan is OFF");
    }
}

//concrete command for light
class LightCommand implements Command{
    private Light light;

    public LightCommand(Light l){
        this.light = l;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}

//concrete command for Fan

class FanCommand implements Command{
    private Fan fan;

    public FanCommand(Fan f){
        this.fan = f;
    }

    public void execute(){
        fan.on();
    }
    public void undo(){
        fan.off();
    }
}


//Invoker: Remote Controller with static array of 4 buttons

class RemoteController{
    private static final int numButtons = 4;
    private Command[] buttons;
    private boolean[] buttonPressed;

    public RemoteController(){
        buttons = new Command[numButtons];
        buttonPressed = new boolean[numButtons];
        for(int i=0; i<numButtons; i++){
            buttons[i] = null;
            buttonPressed[i] = false;
        }
    }

    public void setCommands(int idx, Command cmd){
        if(idx >= 0 && idx < numButtons){
            buttons[idx] = cmd;
            buttonPressed[idx] = false;
        }
    }

    public void pressButton(int idx){
        if(idx >= 0 && idx < numButtons && buttons[idx] != null){
            if(!buttonPressed[idx]){
                buttons[idx].execute();
            }else{
                buttons[idx].undo();
            }
            buttonPressed[idx] = !buttonPressed[idx];
        }else{
            System.out.println("No command assigned at button " + idx);
        }
    }
}i

public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Fan ceiliengFan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommands(0, new LightCommand(livingRoomLight));
        remote.setCommands(1, new FanCommand(ceiliengFan));

        System.out.println("--- Toggling Light Button 0 ---");
        remote.pressButton(0); //ON
        remote.pressButton(0); //OFF

        System.out.println("---Toggling Fan Button 1 ---");
        remote.pressButton(1);
        remote.pressButton(1);

        System.out.println("---Pressing Unassigned Button 2 ---");
        remote.pressButton(2);
    }
}
