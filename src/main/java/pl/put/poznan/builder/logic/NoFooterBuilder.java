package pl.put.poznan.builder.logic;

public class NoFooterBuilder implements MiniBuilderComponent {

    private String component;

    public NoFooterBuilder() {
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
