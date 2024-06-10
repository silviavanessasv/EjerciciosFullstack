package com.certidevs.proyecto2;

public class Post {

    private Long id;

    private String content; // length = 5000

    private String photoUrl;

    private String videoUrl; // video de youtube

    // un enum PostType: SHORT, LONG, ARTICLE, VIDEO

    // cuando el post se publica en modo normal el grupo es null
    // cuando el post se publica dentro de un grupo entonces tiene objeto Grupo
    private Group group;


}
