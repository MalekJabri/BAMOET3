
package org.acme.message;

public class Message {

    private String id;
    private String content;

    public Message() {

    }

    public Message(String id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{ 'id': '" + id + "', 'content': '" + content + "'" + "}";
    }
}
