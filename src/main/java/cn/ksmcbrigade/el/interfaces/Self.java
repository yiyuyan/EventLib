package cn.ksmcbrigade.el.interfaces;

public interface Self<T> {
    default T getSelf(){
        return (T)((Object)this);
    }
}
