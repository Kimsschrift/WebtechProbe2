
import { describe, it, expect, vi, beforeEach } from 'vitest'
import { mount } from '@vue/test-utils'
import axios from 'axios'
import ChuckNorrisQuote from '../ChuckNorrisQuote.vue'



vi.mock('axios')

describe('ChuckNorrisQuote.vue', () => {

    beforeEach(() => {

      vi.clearAllMocks()
    })

    it('loads and displays a random quote when the component is mounted', async () => {

      const mockQuote = 'Wenn alles funktioniert, steht hier ein Chuck Norris Spruch.'
      axios.get.mockResolvedValue({
        data: {
          quote: mockQuote
        }
      })


      const wrapper = mount(ChuckNorrisQuote)


      expect(axios.get).toHaveBeenCalledWith(expect.stringContaining('api/v1/quotes?index='))


      await wrapper.vm.$nextTick()
      await wrapper.vm.$nextTick()


      const heading = wrapper.find('h1')
      expect(heading.text()).toContain(mockQuote)
    })
  })