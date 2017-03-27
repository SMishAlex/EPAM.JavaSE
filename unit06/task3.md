class MedicalStaff{}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}


||correct|not correct| Explain|
|-|-|-|
|Doctor doctor1 = new Doctor();|correct|ref and object have same type|
|Doctor doctor2 = new MedicalStaff();|incorrect|medical staff super class for doctor|
|Doctor doctor3 = new HeadDoctor();|correct|doctor staff super class for head doctor|
|Object object1 = new HeadDoctor();|correct|object is super for all classes in Java|
|HeadDoctor doctor5 = new Object();|incorrect|object is super for all classes in Java|
|Doctor doctor6  = new Nurse();|incorrect|have same super but no relations between each other|
|Nurse nurse = new Doctor();|incorrect|have same super but no relations between each other|
|Object object2 = new Nurse();|correct|object is super for all classes in Java|
|List<Doctor> list1= new ArrayList<Doctor>();|correct|ref and object have same type|
|List<MedicalStaff> list2 = new ArrayList<Doctor>();|correct|medical staff super class for doctor|
|List<Doctor> list3 = new ArrayList<MedicalStaff>();|incorrect|medical staff super class for doctor|
|List<Object> list4 = new ArrayList<Doctor>();|correct|object is super for all classes in Java|
|List<Object> list5 = new ArrayList<Object>();|correct|ref and object have same type|
