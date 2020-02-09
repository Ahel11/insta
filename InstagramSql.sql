 
use instagram

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


select * from instagramusername where instagramusername.UserName like '%fashion%' limit 100000000


INSERT INTO instagramuser VALUES(0,0,'dewdrob26','"',661,283,0,'','',false,'null',0,false,false,'null')



select * from instagramuser 
where (instagramuser.BioAndDesc like '%outlook%' OR 
instagramuser.BioAndDesc like '%gmail%'  OR
instagramuser.BioAndDesc like '%yahoo%') AND 
instagramuser.BioAndDesc like '%fitness%'
limit 100000000
  




































