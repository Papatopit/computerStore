create table hard_drive (
    id                  bigserial not null,
    manufacturer        varchar(255),
    price               int8,
    serial_number       int8,
    units_in_stock      int8,
    capacity            int8,
    primary key         (id)
);

create table laptop (
    id                  bigserial not null,
    manufacturer        varchar(255),
    price               int8,
    serial_number       int8,
    units_in_stock      int8,
    screen_inch         int4,
    primary key         (id)
);

create table monitor (
    id                  bigserial not null,
    manufacturer        varchar(255),
    price               int8,
    serial_number       int8,
    units_in_stock      int8,
    diagonal            int8,
    primary key         (id)
);

create table desktop_computer (
   id                   bigserial not null,
   manufacturer         varchar(255),
   price                int8,
   serial_number        int8,
   units_in_stock       int8,
   form_factor          int4,
   primary key          (id)
);