package com.certidevs.proyecto2;

import java.time.LocalDateTime;

// entidad intermedia entre User y Post
public class Interaction {

    private Long id;

    private Boolean liked;
    private LocalDateTime likedDate;

    private Boolean shared;
    private LocalDateTime sharedDate;

    private Boolean saved;
    private LocalDateTime savedDate;

    private String comment;
    private LocalDateTime commentDate;

    private User user;
    private Post post;
}
