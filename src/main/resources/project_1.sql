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

INSERT INTO ers_reimbursements ()

SELECT * FROM ers_user_roles;  
SELECT * FROM ers_users; 
select * from ers_reimbursements;
