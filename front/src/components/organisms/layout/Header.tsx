import { Flex, Heading } from '@chakra-ui/react'
import { memo, VFC } from 'react'

export const Header: VFC = memo(() => {
  return (
    <Flex
      as="nav"
      align="center"
      justify="space-between"
      bg="gray.900"
      color="gray.100"
      padding={{ base: 3, md: 5 }}
    >
      <Flex align="center" as="a" mr={8}>
        <Heading as="h1" fontSize={{ base: 'md', md: 'lg' }}>
          nijiDB
        </Heading>
      </Flex>
    </Flex>
  )
})
