package examples.aaronhoskins.com.mvvmdemo.model.designpatterns;

public class Singleton {
    static Singleton singleton;
    String tag;

    public static synchronized Singleton getInstance(String tag){
        if(singleton == null) {
            singleton = new Singleton(tag);
        }
        return singleton;
    }


    private Singleton(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
