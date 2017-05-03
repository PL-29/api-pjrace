package fr.solocal.builder;

/**
 * Created by stage01 on 03/05/17.
 */
public class MessageDTO {
    String denomination;
    Object content;

    public MessageDTO(String denomination, Object content) {
        this.denomination = denomination;
        this.content = content;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
