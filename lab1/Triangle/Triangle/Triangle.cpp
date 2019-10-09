#include <iostream>
#include <vector>
#include <string>

namespace AnswerOptions
{
	const std::string Common = "Common";
	const std::string Isosceles = "Isosceles";
	const std::string Equilateral = "Equilateral";
	const std::string NotTriangle = "NotTriangle";
	const std::string UnknownError = "UnknownError";
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

std::string DetermineTriangleType(std::vector<int>& triangleSide)
{
	const int a = triangleSide[0];
	const int b = triangleSide[1];
	const int c = triangleSide[2];

	if (isTriangle(a, b, c))
	{
		if (isEquilateralTriangle(a, b, c))
		{
			return AnswerOptions::Equilateral;
		}

		if (isIsoscelesTriangle(a, b, c))
		{
			return AnswerOptions::Isosceles;
		}

		return AnswerOptions::Common;
	}

	return AnswerOptions::NotTriangle;
}

int main(int argc, char* argv[])
{
	if (argc != 4)
	{
		std::cout << AnswerOptions::UnknownError << std::endl;
		return 1;
	}

	std::vector<int> triangleSide;

	try {
		for (int i = 1; i < argc; i++)
		{
			triangleSide.push_back(std::stoi(argv[i]));
		}
	}
	catch (std::exception&)
	{
		std::cout << AnswerOptions::UnknownError << std::endl;
		return 1;
	}

	std::cout << DetermineTriangleType(triangleSide) << std::endl;

	return 0;
}

