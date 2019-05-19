update salary
set sex = case when sex = 'm' then 'f' else 'm' end;
update salary
set sex = case sex when 'm' then 'f' else 'm' end;
update salary
set sex = char(ASCII('m') ^ ASCII('f') ^ ASCII(sex));
