// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleBank {

    mapping(address => uint256) private balances;

    // Deposit money into your bank account
    function deposit() public payable {
        require(msg.value > 0, "Amount must be greater than zero");
        balances[msg.sender] += msg.value;
    }

    // Withdraw money from your bank account
    function withdraw(uint256 amount) public {
        require(balances[msg.sender] >= amount, "Not enough balance");
        balances[msg.sender] -= amount;
        payable(msg.sender).transfer(amount);
    }

    // Show your account balance
    function getBalance() public view returns (uint256) {
        return balances[msg.sender];
    }
}
