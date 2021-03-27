package com.itheima.pojo;

import java.util.Objects;

public class URL {

    private String name;
    private int port;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url = (URL) o;
        return port == url.port && Objects.equals(name, url.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, port);
    }

    public String getName() {
        return name;
    }

    public URL(String name, int port) {
        this.name = name;
        this.port = port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


}
