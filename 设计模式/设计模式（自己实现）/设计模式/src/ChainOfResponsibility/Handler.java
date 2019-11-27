package ChainOfResponsibility;

public abstract class Handler {
    private String name;

    protected Handler next;

    public Handler(String name) {
        this.name = name;
    }

    public Handler setNext(Handler handler){
        this.next=handler;
        return next;
    }

    public abstract boolean resolve();

    public abstract void success();

    public abstract void faile();

    public final void support(){
        if(resolve())
            success();
        else if(next!=null)
            next.support();
        else
            faile();
    }
}
