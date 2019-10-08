#include <iostream>
#include <vector>
#include <string>

struct AnswerOptions
{
	std::string common = "Common";
	std::string isosceles = "Isosceles";
	std::string equilateral = "Equilateral";
	std::string notTriangle = "NotTriangle";
	std::string unknownError = "UnknownError";
};

bool isTriangle(const int a, const int b, const int c)
{
	if ((a + b > c) && (b + c > a) && (c + a > b))
	{
		return true;
	}
	return false;
}

bool isIsoscelesTriangle(const int a, const int b, const int c)
{
	if (a == b || b == c || a == c)
	{
		return true;
	}
	return false;
}


bool isEquilateralTriangle(const int a, const int b, const int c)
{
	if (a == b && b == c)
	{
		return true;
	}
	return false;
}

std::string DetermineTriangleType(std::vector<int>& triangleSide, AnswerOptions answerOptions)
{
	const int a = triangleSide[0];
	const int b = triangleSide[1];
	const int c = triangleSide[2];

	if (isTriangle(a, b, c))
	{
		if (isEquilateralTriangle(a, b, c))
		{
			return answerOptions.equilateral;
		}

		if (isIsoscelesTriangle(a, b, c))
		{
			return answerOptions.isosceles;
		}

		return answerOptions.common;
	}

	return answerOptions.notTriangle;
}

int main(int argc, char* argv[])
{
	setlocale(LC_ALL, "Russian");

	AnswerOptions answerOptions = AnswerOptions();

	if (argc != 4)
	{
		std::cout << answerOptions.unknownError << std::endl;
		return 1;
	}

	std::vector<int> triangleSide;

	try {
		for (int i = 1; i < argc; i++)
		{
			triangleSide.push_back(std::stoi(argv[i]));
		}
	}
	catch (...)
	{
		std::cout << answerOptions.unknownError << std::endl;
		return 1;
	}

	std::cout << DetermineTriangleType(triangleSide, answerOptions) << std::endl;


	return 0;
}

