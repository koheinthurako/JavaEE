package StoreProcedure;

public class StoreProcedure {

//	Database က Stored Procedure ဆိုတာဘာလဲ?
//	java ထဲမှာလို method တွေကို Database မှာရေးနိုင်တဲ့ feature တစ်ခုဖြစ်တယ် အောက်ကလို Database ထဲက Stored Procedure မှာသွားရေးတယ်
	
	 /* 
	  	CREATE DEFINER=`root`@`localhost` PROCEDURE `add_score`(stuNum int, subNum varchar(3), examDate date)
		BEGIN
			-- score ကို ထည့်မပေးလိုက်ဘူး default 40 auto ဖြစ်အောင်ရေးမယ်ဆိုရင်
			insert into score(studentNumber, subjectNumber, ExaminationDate)
				values (stuNum, subNum, examDate);
			update score set Score = 40 where studentNumber = stuNum and subjectNumber = subNum;
		END
	 */
		
}
