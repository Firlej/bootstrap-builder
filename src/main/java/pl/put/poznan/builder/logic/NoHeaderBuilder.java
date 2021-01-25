package pl.put.poznan.builder.logic;

public class NoHeaderBuilder implements MiniBuilderComponent {

    private String component;

    public NoHeaderBuilder() {
        this.component = "";
    }

    @Override
    public void setComponent() {
    }

    @Override
    public String getComponent() {
        return component;
    }
}
