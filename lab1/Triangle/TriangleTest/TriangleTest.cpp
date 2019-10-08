#include <cstdio>
#include <iostream>
#include <memory>
#include <stdexcept>
#include <string>
#include <array>
#include <filesystem>
#include <fstream>
#include <sstream>
#include <ostream>

std::string exec(const char* cmd) {
	std::array<char, 128> buffer;
	std::string result;
	std::unique_ptr<FILE, decltype(&_pclose)> pipe(_popen(cmd, "r"), _pclose);
	if (!pipe) {
		throw std::runtime_error("popen() failed!");
	}
	while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {
		result += buffer.data();
	}
	return result;
}

int main(int argc, char* argv[])
{
	if (argc != 3)
	{
		std::cerr << "Invalid arguments count\n";
		return 1;
	}

	std::ifstream input(argv[2]);

	if (!input.is_open())
	{
		std::cout << "Can`t open input test file" << std::endl;
		return 1;
	}

	std::string inputStr;
	std::ofstream output("testResult.txt");

	while (std::getline(input, inputStr))
	{
		std::istringstream sstream(inputStr);
		std::string testCount, a, b, c, result;
		sstream >> testCount >> a >> b >> c >> result;
		std::string execStr = " " + a + " " + b + " " + c;
		auto resultExec = exec(std::string(argv[1] + execStr).c_str());

		if (resultExec == result + "\n")
		{
			output << testCount << " Success" << std::endl;
		}
		else
		{
			output << testCount << " Failure" << std::endl;
		}
	}
}