 
use instagram

create table cometonaccount
(
	id INT NOT NULL AUTO_INCREMENT,
    UserName VARCHAR(100) NOT NULL UNIQUE,
    Pass VARCHAR(100) NOT NULL,
    MailAddress VARCHAR(100) NOT NULL UNIQUE,
    NumberOfQueriesAllocation VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);



INSERT INTO cometonaccount VALUES(0,'rafael1993','pass1' ,'mail12@gmail.com',350000);



SELECT * from cometonaccount;


CREATE table instagramuser
(
	id INT NOT NULL AUTO_INCREMENT,
	Pk Long NOT NULL,
    UserName VARCHAR(60) NOT NULL UNIQUE,
    BioAndDesc VARCHAR(8000) NOT NULL,
    FollowingCount Long NOT NULL,
    FollowerCount Long NOT NULL,
    MediaCount Long NOT NULL,
    PhoneNumber VARCHAR(30) NOT NULL,
    Mail VARCHAR(50) NOT NULL,
    IsVerified BOOLEAN NOT NULL,
    ExternalUrl VARCHAR(150) NOT NULL,
    NrOfHighlights Long NOT NULL,
    IsBusinessAccount BOOLEAN NOT NULL,
    IsRecentlyJoined BOOLEAN NOT NULL,
    businessCategoryName VARCHAR(150) NOT NULL,
    PRIMARY KEY(id)
);

CREATE table instagramusername
(
	id INT NOT NULL AUTO_INCREMENT,
    UserName VARCHAR(60) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);




select * from instagramuser limit 100000000




select * from instagramusername limit 100000000

SELECT * FROM  instagramuser
WHERE instagramuser.FollowingCount >= 200
AND instagramuser.FollowerCount >= 1555
AND (instagramuser.FollowerCount / instagramuser.FollowingCount) > 1
AND instagramuser.IsVerified = false
AND instagramuser.IsBusinessAccount = false
AND instagramuser.IsRecentlyJoined = false
AND instagramuser.BioAndDesc like '%fashion%'
AND instagramuser.BioAndDesc like '%fitness%'



select * from instagramusername where instagramusername.UserName like '%fashion%' limit 100000000


INSERT INTO instagramuser VALUES(0,0,'dewdrob26','"',661,283,0,'','',false,'null',0,false,false,'null')



select * from instagramuser
where (instagramuser.BioAndDesc like '%outlook%' OR
instagramuser.BioAndDesc like '%gmail%'  OR
instagramuser.BioAndDesc like '%yahoo%')
AND instagramuser.BioAndDesc like '%Blogger%'
AND instagramuser.BioAndDesc like '%DM%'
limit 100000000



select * from instagramuser
where instagramuser.BioAndDesc like '%outlook%' OR
instagramuser.BioAndDesc like '%gmail%'  OR
instagramuser.BioAndDesc like '%mail%'
limit 100000000







SELECT * FROM instagramuser
WHERE instagramuser.FollowingCount >= 11
AND instagramuser.FollowerCount >= 5000
AND instagramuser.NrOfHighlights >= 0
AND instagramuser.IsVerified = 0
AND instagramuser.IsBusinessAccount = 0
AND instagramuser.IsRecentlyJoined = 0
AND instagramuser.Mail != NULL
AND instagramuser.BioAndDesc like '%shoutout%'
AND instagramuser.BioAndDesc like '%dm%'











SELECT * FROM FROM instagramuser 
WHERE
instagramuser.FollowingCount >= 95AND instagramuser.IsVerified = trueAND instagramuser.IsBusinessAccount = falseAND instagramuser.IsRecentlyJoined = falseAND instagramuser.BioAndDesc like '%tempus%'AND instagramuser.BioAndDesc like '%inerga%'AND instagramuser.BioAndDesc like '%mastuberga%'AND instagramuser.BioAndDesc like '%hitlerierga%'












