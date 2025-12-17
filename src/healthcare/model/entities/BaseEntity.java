package healthcare.model.entities;

public abstract class BaseEntity {
    private String id;
    
    public BaseEntity(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + id + "]";
    }
}
