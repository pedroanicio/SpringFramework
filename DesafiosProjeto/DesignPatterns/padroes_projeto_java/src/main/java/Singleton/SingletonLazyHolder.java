package Singleton;

public class SingletonLazyHolder {

    //encapsular instancia
    private static class Holder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();;
    }
    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstance(){
        return Holder.instancia;
    }
}
