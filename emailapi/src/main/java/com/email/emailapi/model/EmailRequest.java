package com.email.emailapi.model;

public class EmailRequest {

    private String subject;
    private String to;
    private String message;

    public EmailRequest(String to, String subject, String message){
        this.subject = subject;
        this.to = to;
        this.message = message;
    }

    public EmailRequest() {}

    public String getSubject(){
        return subject;
    }
    public String getTo(){
        return to;
    }
    public String getMessage(){
        return message;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setTo(String to){
        this.to = to;
    }
    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "subject='" + subject + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
