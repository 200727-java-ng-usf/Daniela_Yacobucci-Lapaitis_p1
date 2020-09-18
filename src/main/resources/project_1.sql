INSERT INTO ers_reimbursement_statuses (reimb_status)
	   VALUES ('Pending'), ('Approved'), ('Denied');

INSERT INTO ers_reimbursement_types (reimb_type)
	   VALUES ('Lodging'), ('Travel'), ('Food'), ('Other'); 
	   
	  commit;

INSERT INTO ers_user_roles (role_name)
	   VALUES ('Admin'), ('Fin mngr'), ('Employee');

INSERT INTO ers_users (username, password, first_name, last_name , email , user_role_id )
	VALUES ('ppalotes', 'pasapasa', 'Pepita', 'Palotes', 'ppalotes@hotmail.com', 3 ),
		   ('meghvu', 'clowntime', 'Meghana', 'Jung', 'amsoon@clown.org', 3 );
		  
INSERT INTO ers_users (username, password, first_name, last_name , email , user_role_id )
	VALUES ('superman', 'secretidentity', 'Clark', 'Kent', 'notreallysuperman@gmail.net', 1 ),
		   ('gemsword', 'lovesteven','Connie', 'Maheswaran', 'cm129@jhopkins.edu', 2),
		   ('realpsyche', '12345', 'Reigen', 'Arataka', 'professionalemail@psyche.net', 4 );

INSERT INTO ers_reimbursements (amount, submitted, description, author_id, reimb_status_id, reimb_type_id)
						VALUES (400.23, NOW(), 'Travel to new york for meeting', 1, 2, 2);
					
INSERT INTO ers_reimbursements (amount, submitted, resolved, description, author_id, resolver_id, reimb_status_id, reimb_type_id)
						VALUES (320.72, 'September 8 04:05:06 2020 PST' , NOW(), 'TBS Concert', 1, 4, 3, 4)

SELECT * FROM ers_user_roles;  
SELECT * FROM ers_users; 
select * from ers_reimbursements;
