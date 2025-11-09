// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {

    // ---------------- Structure ----------------
    struct Student {
        uint256 roll;
        string name;
        uint8 age;
    }

    
    Student[] public students;

   
    function addStudent(uint256 _roll, string memory _name, uint8 _age) public {
        students.push(Student(_roll, _name, _age));
    }

    
    function getStudent(uint256 index) public view returns (uint256, string memory, uint8) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.roll, s.name, s.age);
    }

    
    function getTotalStudents() public view returns (uint256) {
        return students.length;
    }

   
    fallback() external payable { }

   
    receive() external payable { }
}
