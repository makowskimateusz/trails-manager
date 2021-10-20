create table booking_hikers
(
    booking_id uuid not null,
    hikers     varchar(255)
);

create table bookings
(
    id             uuid not null,
    booking_status varchar(255),
    total_cost     numeric(19, 2),
    trail_name     varchar(255),
    primary key (id)
);

create table trails
(
    id          uuid not null,
    end_at      time,
    maximum_age int4 not null,
    minimum_age int4 not null,
    name        varchar(255),
    start_at    time,
    unit_price  numeric(19, 2),
    primary key (id)
);

alter table booking_hikers
    add constraint booking foreign key (booking_id) references bookings;