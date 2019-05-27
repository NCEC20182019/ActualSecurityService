INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types)
 VALUES
    ('event_service', '{bcrypt}$2a$12$35g/YiCv6zcxdjXCyPkopedF37PpA5ATp5s3ZIbUrdo/4qVe6Lg16', 'http://localhost:8092', 'profile', 3600, 10000, 'events', 'authorization_code,password,refresh_token,implicit'),
    ('parser_service', '{bcrypt}$2a$12$HU2SKOk7O9ubgAv9HHUDt.uTT2xL6svF2DPF1szFpDFeOpkAh6Gwa', 'http://localhost:8094', 'profile', 3600, 10000, 'events', 'client_credentials'),
    ('scheduler_service', '{bcrypt}$2a$12$.8M7UW7ruyS8QQ/dNu8lJ.6REyLBToSSyZr/I70ysN.miaLNKSssm', 'http://localhost:8095', 'profile', 3600, 10000, 'events', 'client_credentials'),
    ('notification_service', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8093', 'profile', 3600, 10000, 'users', 'authorization_code,password,refresh_token,implicit,client_credentials'),
    ('client_service', '{bcrypt}$2a$12$fvO3jGsXa4yNoAq1YbuTNO6YfJ/qNdS9zug9aZ8V0b6Ry.7ACwCa6', 'http://localhost:8090', 'profile, user', 3600, 10000, 'users', 'authorization_code,password,refresh_token,implicit,client_credentials')
;

 INSERT INTO PERMISSION (NAME)
  VALUES
    ('create_profile'),
    ('read_profile'),
    ('update_profile'),
    ('delete_profile')
;

 INSERT INTO role (NAME)
  VALUES
		('ROLE_admin'),
    ('ROLE_user')
;

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID)
  VALUES
     (1,1),
     (2,1),
     (3,1),
     (4,1),
     (1,2),
     (2,2),
     (3,2)

;

INSERT INTO "user" (username, password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, preffered_notify)
  VALUES
     ('marqueez','{bcrypt}$2a$10$Dk1SaUYfoDzs.FQQnKFh/.7uecubERVT8xIfqqSCrrAyNmPcQLRu2', 'dominiqewilkins@gmail.com', '1', '1', '1', '1', 'EMAIL')
;

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
  VALUES
    (1, 1)
;
